void main() {
  //dynamic variable = 2;
  
  //Los maps son partes de valores
  final Map<String, dynamic> pokemos ={
    'nombre' : 'Ditto',
    'hp' : 100,
    'isAlive' : true,
    'sprites' : {
      1: 'ditto/front.jpg',
      2: 'dotto/back.jpg'
    }
  };
  print(pokemos);
  print('Nombre: ${pokemos['nombre']}');
  print('Pokemon: ${pokemos['sprites']}');

  print('Pokemon: ${pokemos['sprites'][2]}');
}