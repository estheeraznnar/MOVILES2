import 'package:flutter/material.dart';

const listaColores = <Color>[
  Colors.blue,
  Colors.teal,
  Colors.green,
  Colors.red,
  Colors.purple,
  Colors.deepPurpleAccent,
  Colors.orange,
  Colors.pink,
  Colors.pinkAccent,
];

class AppTheme {
  final int colorSeleccionado;
  new({
    this.colorSeleccionado = 0
  }):assert(colorSeleccionado >=0, 'El color seleccionado debe ser mayor de 0'), 
  assert(colorSeleccionado < listaColores.length, 'El color seleccionado debe ser igual o menor que ${listaColores.length}');

  ThemeData getTheme() => ThemeData(
    useMaterial3: true,
    colorSchemeSeed: listaColores[colorSeleccionado],
    //Appbar
    appBarTheme: AppBarTheme(centerTitle: true),
  );

  // Color primario
  static const Color primary = Colors.orange;
  static const Color secondary = Colors.yellow;

  // Tema Light
  static final ThemeData lightTheme = ThemeData.light().copyWith(
    //Color primario
    primaryColor: primary,
    useMaterial3: false,
    // AppBar
    appBarTheme: AppBarTheme(backgroundColor: primary, elevation: 0),
  );

  // Tema Halloween
  static final ThemeData halloweenTheme = ThemeData.dark().copyWith(
    //Color primario
    primaryColor: Colors.orangeAccent,
    primaryColorDark: Colors.orangeAccent,

    //scaffoldBackgroundColor: Colors.blueGrey
  );
}
