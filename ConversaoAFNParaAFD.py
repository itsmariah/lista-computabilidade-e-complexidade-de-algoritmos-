# 17) Implemente em Python a conversão de um AFN para um AFD para um autômato que reconhece strings terminadas em '01'.

from collections import defaultdict

class AFN:
    def __init__(self):
        self.transitions = defaultdict(lambda: defaultdict(set))
        self.start_state = 'q0'
        self.accept_states = {'q2'}
        self.add_transition('q0', '0', 'q1')
        self.add_transition('q0', '1', 'q0')
        self.add_transition('q1', '0', 'q1')
        self.add_transition('q1', '1', 'q2')
        self.add_transition('q2', '0', 'q1')
        self.add_transition('q2', '1', 'q0')

    def add_transition(self, from_state, input_char, to_state):
        self.transitions[from_state][input_char].add(to_state)

    def get_transitions(self, state, input_char):
        return self.transitions[state][input_char] if input_char in self.transitions[state] else set()

class AFD:
    def __init__(self, afn):
        self.afn = afn
        self.dfa_transitions = {}
        self.start_state = frozenset([afn.start_state])
        self.accept_states = set()
        self.build_dfa()

    def build_dfa(self):
        unprocessed_states = [self.start_state]
        processed_states = set()

        while unprocessed_states:
            current_dfa_state = unprocessed_states.pop()
            processed_states.add(current_dfa_state)
            
            for char in ['0', '1']:
                next_states = set()
                for afn_state in current_dfa_state:
                    next_states.update(self.afn.get_transitions(afn_state, char))
                
                next_dfa_state = frozenset(next_states)

                if next_dfa_state:
                    self.dfa_transitions[(current_dfa_state, char)] = next_dfa_state

                    if next_dfa_state not in processed_states and next_dfa_state not in unprocessed_states:
                        unprocessed_states.append(next_dfa_state)
                        
                    if next_dfa_state & self.afn.accept_states:
                        self.accept_states.add(next_dfa_state)

    def accepts(self, input_string):
        current_state = self.start_state
        
        for char in input_string:
            current_state = self.dfa_transitions.get((current_state, char), None)
            if current_state is None:
                return False

        return current_state in self.accept_states


if __name__ == "__main__":
    afn = AFN()
    afd = AFD(afn)

    test_strings = [
        "01",
        "1101",
        "001",
        "11",
        "111",
        "010",
        "1010101",
        "0",
    ]
    
    for s in test_strings:
        print(f'A string "{s}" é aceita? {afd.accepts(s)}')