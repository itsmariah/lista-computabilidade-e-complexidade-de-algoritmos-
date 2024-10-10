# 9) Construa um AFD em Python que reconheça strings contendo a sequência "101".

class AFDReconheceSequencia101:
    def __init__(self):
        
        self.states = {
            'q0': 'Estado inicial',
            'q1': 'Reconheceu 1',
            'q2': 'Reconheceu 10',
            'q3': 'Reconheceu 101 (aceitação)',
        }
        self.current_state = 'q0'

    def transition(self, input_char):
        if self.current_state == 'q0':
            if input_char == '1':
                self.current_state = 'q1'
            elif input_char == '0':
                self.current_state = 'q0'
        elif self.current_state == 'q1':
            if input_char == '0':
                self.current_state = 'q2'
            elif input_char == '1':
                self.current_state = 'q1'
        elif self.current_state == 'q2':
            if input_char == '1':
                self.current_state = 'q3'
            elif input_char == '0':
                self.current_state = 'q0'
        elif self.current_state == 'q3':
            self.current_state = 'q3'

    def accepts(self, input_string):
        self.current_state = 'q0'
        for char in input_string:
            self.transition(char)
        return self.current_state == 'q3'

if __name__ == "__main__":
    afd = AFD()
    
    test_strings = [
        "101",
        "110",
        "011010",
        "1001",
        "00101",
        "010101",
        "0000",
        "11111",
        "10101", 
        "010010",
        "10010"
    ]
    
    for s in test_strings:
        print(f'A string "{s}" é aceita? {afd.accepts(s)}')
