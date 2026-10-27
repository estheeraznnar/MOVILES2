import 'package:flutter/material.dart';

class AppTheme {
  //color primario
  static const Color primary = Color.fromARGB(255, 212, 97, 135);
  static const Color secondary = Color.fromARGB(255, 109, 116, 153);
  static const Color terciary = Color.fromARGB(255, 255, 178, 91);
  static const Color halloweeen = Colors.orangeAccent;

  static final ThemeData lightTheme = ThemeData.light().copyWith(
    //color primario
    primaryColor: primary,
    useMaterial3: false,
    //AppBar
    appBarTheme: AppBarTheme(backgroundColor: primary, elevation: 0),
  );

  static final ThemeData halloweenTheme = ThemeData.dark().copyWith(
    primaryColor: Colors.orangeAccent,
    primaryColorDark: Colors.orangeAccent,

    iconTheme: IconThemeData(color: halloweeen),
  );
}
