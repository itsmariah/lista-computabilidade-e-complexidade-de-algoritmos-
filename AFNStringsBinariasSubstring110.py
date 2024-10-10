# 12) Implemente um AFN que reconheça strings binárias contendo a substring '110'.

class AFNStringsBinariasSubstring110n:
    def __init__(self):
    
        self.states = {
            'q0': 'Estado inicial (não reconheceu "110")',
            'q1': 'Reconheceu "1" (aguardando "1")',
            'q2': 'Reconheceu "11" (aguardando "0")',
            'q3': 'Reconheceu "110" (estado de aceitação)',
        }
        self.current_states = {'q0'}

    def transition(self, input_char):
        new_states = set()
        for state in self.current_states:
            if state == 'q0':
                if input_char == '0':
                    new_states.add('q0')
                elif input_char == '1':
                    new_states.add('q1')
            elif state == 'q1':
                if input_char == '0':
                    new_states.add('q0')
                elif input_char == '1':
                    new_states.add('q2')
            elif state == 'q2':
                if input_char == '0':
                    new_states.add('q3')
                elif input_char == '1':
                    new_states.add('q2')
            elif state == 'q3':
                new_states.add('q3')

        self.current_states = new_states

    def accepts(self, input_string):
        self.current_states = {'q0'}
        for char in input_string:
            self.transition(char)
        
        return 'q3' in self.current_states

if __name__ == "__main__":
    afn = AFNStringsBinariasSubstring110n()
    
   
    test_strings = [
        "110",
        "101",
        "0110",
        "00110",
        "111",
        "000",
        "1001",
        "010101",
        "000111",
        "110110",
        "011011",
        "11111",
        "101101",
        "0000",
    ]
    
    for s in test_strings:
        print(f'A string "{s}" é aceita? {afn.accepts(s)}')
