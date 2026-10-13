void main(){
  final numbers = [1,2,3,4,5,5,5,6,6,7,7,7,7,8,9,10,11,11];

  print('Lista original: $numbers');
  print('Tamaño: ${numbers.length}');
  print('Index 0: ${numbers[0]}');
  print('First: ${numbers.first}');
 // print('Reversed: ${numbers.reversed}');

  final reversedNumber =numbers.reversed;
  print('Iterable: $reversedNumber');
  print('Lista: ${reversedNumber.toList()}');
  print('Set: ${reversedNumber.toSet()}');

  final numMasQue5 = numbers.where((int num){
    return num > 5;
  });
  print('Numeros mayores de 5: $numMasQue5');
}