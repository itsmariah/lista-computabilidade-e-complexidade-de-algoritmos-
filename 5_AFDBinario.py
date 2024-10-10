#5) Implemente em Python um AFD que aceite qualquer string binária que comece e termine com o mesmo caractere

def afd_binary_string(string):
    state = 0

    for char in string:
        if state == 0:
            if char == '0':
                state = 1
            elif char == '1':
                state = 2
            else:
                return False
        elif state == 1:
            if char not in ('0', '1'):
                return False
            
        elif state == 2:
            if char not in ('0', '1'):
                return False
            

    return (state == 1 and string[-1] == '0') or (state == 2 and string[-1] == '1')


if __name__ == "__main__":
    input_string = input("Digite uma string binária: ")
    if afd_binary_string(input_string):
        print("A string é aceita (começa e termina com o mesmo caractere).")
    else:
        print("A string não é aceita (não começa e termina com o mesmo caractere).")
