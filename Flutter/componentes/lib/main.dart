import 'package:componentes/theme/app_theme.dart';
import 'package:flutter/material.dart';

import 'presentation/screens.dart';

void main() => runApp(const MyApp());

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'Material App',
      // home: ListView1Screen(),
      initialRoute: "/",
      routes: {
        "/": (BuildContext context) => HomeScreen(),
        "listview1": (context) => ListView1Screen(),
        "listview2": (context) => ListView2Screen(),
        "alert": (context) => AlertScreen(),
        "card": (context) => CardScreen(),
      },
      onGenerateRoute: (settings) =>
          MaterialPageRoute(builder: (context) => HomeScreen()),
      theme: AppTheme.lightTheme,
    );
  }
}
