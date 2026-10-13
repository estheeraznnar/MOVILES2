

import 'package:contador/presentation/screens/contador_screen.dart';
import 'package:flutter/material.dart';

void main() {
 // print('Hola Mundo');
    runApp(MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});
  
@override
  Widget build(BuildContext context) {
    return MaterialApp(
        debugShowCheckedModeBanner: false,
        home: ContadorScreen(),
    );
  }
}