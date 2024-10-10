# 11) Construa um AFD para uma linguagem sobre o alfabeto {a, b}, que reconheça strings com um número ímpar de 'a's.

class AFDStringsNumeroImpar:
    def __init__(self):
        
        self.states = {
            'q0': 'Estado inicial (número par de a\'s)',
            'q1': 'Número ímpar de a\'s (estado de aceitação)',
        }
        self.current_state = 'q0'

    def transition(self, input_char):
        if self.current_state == 'q0':
            if input_char == 'a':
                self.current_state = 'q1'
            elif input_char == 'b':
                self.current_state = 'q0'
        elif self.current_state == 'q1':
            if input_char == 'a':
                self.current_state = 'q0'
            elif input_char == 'b':
                self.current_state = 'q1'

    def accepts(self, input_string):
        self.current_state = 'q0'
        for char in input_string:
            self.transition(char)
        return self.current_state == 'q1'


if __name__ == "__main__":
    afd = AFD()
    
    test_strings = [
        "a",
        "b",
        "aa",
        "ab",
        "ba",
        "bba",
        "aab",
        "aabb",
        "aaa",
        "abab",
        "babab",
        "bbb",
        "aaaa",
        "abbaa",
    ]
    
    for s in test_strings:
        print(f'A string "{s}" é aceita? {afd.accepts(s)}')
