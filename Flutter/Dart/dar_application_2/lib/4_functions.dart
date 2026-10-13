void main() {
  print(Saludar());
  print(Saludar2());

  print(sumar(2,7));

  print(sumarOpcional(5));
  print(saludoCompleto(nombre: 'Esther', mensaje: 'Vete ya a casa'));
}

String Saludar() => 'Hola Esther';

String Saludar2 (){
  return 'Hola Esther.A';
}

int sumar(int a, int b) => a+b;

int sumarOpcional(int a, [int b = 0]){
  return a + b;
}

//Parametros con nombre
String saludoCompleto({required nombre, String mensaje = 'Buenas'}){
  return '$mensaje $nombre';
}