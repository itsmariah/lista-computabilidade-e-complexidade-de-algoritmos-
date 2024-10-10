# 14) Crie um AFN que aceite strings binárias onde as substrings "11" e "00" não aparecem.

class AFNSubstrings11e00NaoAparecem:
    def __init__(self):
        
        self.states = {
            'q0': 'Estado inicial (não reconheceu "11" ou "00")',
            'q1': 'Último caractere foi "0"',
            'q2': 'Último caractere foi "1"',
            'q_reject': 'Estado de rejeição (reconheceu "11" ou "00")'
        }
        self.current_states = {'q0'}

    def transition(self, input_char):
        new_states = set()
        for state in self.current_states:
            if state == 'q0':
                if input_char == '0':
                    new_states.add('q1')
                elif input_char == '1':
                    new_states.add('q2')
            elif state == 'q1':
                if input_char == '0':
                    new_states.add('q_reject')
                elif input_char == '1':
                    new_states.add('q2')
            elif state == 'q2':
                if input_char == '0':
                    new_states.add('q1')
                elif input_char == '1':
                    new_states.add('q_reject')
            elif state == 'q_reject':
                new_states.add('q_reject')

        self.current_states = new_states

    def accepts(self, input_string):
        self.current_states = {'q0'}
        for char in input_string:
            self.transition(char)
    
        return 'q0' in self.current_states or 'q1' in self.current_states or 'q2' in self.current_states


if __name__ == "__main__":
    afn = AFNSubstrings11e00NaoAparecem()
    
    
    test_strings = [
        "0",
        "1",
        "01",
        "10",
        "001",
        "110",
        "0101",
        "1010",
        "0110",
        "1001",
        "111",
        "000",
        "010",
        "100",
        "1100",
        "10101",
        "10010",
        "0001",
    ]
    
    for s in test_strings:
        print(f'A string "{s}" é aceita? {afn.accepts(s)}')
