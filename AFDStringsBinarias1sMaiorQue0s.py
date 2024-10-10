# 13) Desenvolva um AFD que reconheça strings binárias onde o número de '1's seja maior que o número de '0's.

class AFDStringsBinarias1sMaiorQue0s:
    def __init__(self):
        
        self.states = {
            'q0': 'Número de 1s igual ao número de 0s',
            'q1': 'Número de 1s maior que o número de 0s (estado de aceitação)',
            'q2': 'Número de 0s maior que o número de 1s (estado de rejeição)',
        }
        self.current_state = 'q0'

    def transition(self, input_char):
        if self.current_state == 'q0':
            if input_char == '1':
                self.current_state = 'q1'
            elif input_char == '0':
                self.current_state = 'q2'
        elif self.current_state == 'q1':
            if input_char == '1':
                self.current_state = 'q1'
            elif input_char == '0':
                self.current_state = 'q0'
        elif self.current_state == 'q2':
            if input_char == '1':
                self.current_state = 'q1'
            elif input_char == '0':
                self.current_state = 'q2'

    def accepts(self, input_string):
        self.current_state = 'q0'
        for char in input_string:
            self.transition(char)
        return self.current_state == 'q1'

if __name__ == "__main__":
    afd = AFDStringsBinarias1sMaiorQue0s()
    
    test_strings = [
        "1",
        "0",
        "11",
        "00",
        "101",
        "001",
        "110",
        "1001",
        "0001",
        "1110",
        "0101",
        "11111",
        "00000",
        "111000",
        "100100",
        "000011",
        "0101100",
    ]
    
    for s in test_strings:
        print(f'A string "{s}" é aceita? {afd.accepts(s)}')
