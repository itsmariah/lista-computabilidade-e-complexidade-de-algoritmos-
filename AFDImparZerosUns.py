# 18) Desenvolva um AFD que reconheça a linguagem de strings sobre {0, 1} com número ímpar de '0's e '1's.

class AFDImparZerosUns:
    def __init__(self):
    
        self.transitions = {
            'q00': {'0': 'q10', '1': 'q01'},
            'q01': {'0': 'q11', '1': 'q00'},
            'q10': {'0': 'q00', '1': 'q11'},
            'q11': {'0': 'q01', '1': 'q10'},
        }
        self.start_state = 'q00'
        self.accept_states = {'q11'}

    def accepts(self, input_string):
        current_state = self.start_state

        for char in input_string:
            current_state = self.transitions[current_state].get(char, None)
            if current_state is None:
                return False

        return current_state in self.accept_states


if __name__ == "__main__":
    automaton = AFDImparZerosUns()

    test_strings = [
        "01",
        "0011",
        "010",
        "1010",
        "111",
        "1100",
        "111000",
        "0",
        "1",
    ]
    
    for s in test_strings:
        result = automaton.accepts(s)
        print(f'A string "{s}" é aceita? {result}')
