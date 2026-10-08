

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
        theme: ThemeData.dark(
            
        ),
        home: Scaffold(
          body: Center(
              child: Text('Hola a Dam 2')),
        ),
    );
  }
}