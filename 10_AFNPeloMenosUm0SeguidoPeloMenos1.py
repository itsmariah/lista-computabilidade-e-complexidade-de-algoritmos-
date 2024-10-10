# 10) Implemente um AFN que aceite qualquer string que tenha pelo menos um '0' seguido de pelo menos um '1'.

class AFNPeloMenosUm0SeguidoPeloMenos1:
    def __init__(self):
        
        self.states = {
            'q0': 'Estado inicial (não reconheceu 0 nem 1)',
            'q1': 'Reconheceu pelo menos um 0 (aguardando 1)',
            'q2': 'Reconheceu pelo menos um 0 seguido de pelo menos um 1 (estado de aceitação)',
        }
        self.current_states = {'q0'}

    def transition(self, input_char):
        new_states = set()
        for state in self.current_states:
            if state == 'q0':
                if input_char == '0':
                    new_states.add('q1')
                elif input_char == '1':
                    new_states.add('q0')
            elif state == 'q1':
                if input_char == '0':
                    new_states.add('q1')
                elif input_char == '1':
                    new_states.add('q2')
            elif state == 'q2':
                
                new_states.add('q2')

        self.current_states = new_states

    def accepts(self, input_string):
        self.current_states = {'q0'}
        for char in input_string:
            self.transition(char)
        
        return 'q2' in self.current_states


if __name__ == "__main__":
    afn = AFNPeloMenosUm0SeguidoPeloMenos1()
    
    test_strings = [
        "01",
        "10",
        "001",
        "000",
        "111",
        "1101",
        "0001",
        "1110",
        "1000",
        "0000111",
        "010101",
        "00000",
    ]
    
    for s in test_strings:
        print(f'A string "{s}" é aceita? {afn.accepts(s)}')
