// Este provider va a manejar el contador de la Pagina 1

import 'package:flutter/material.dart';

//changeNotifier es una clase que proporciona notificaciones a los widgets cuando el estado cambia
class ContadorProvider extends ChangeNotifier {
  //Cunaod tenemos un estado con Provider hemos de poder hacer DOS cosas:
  //1- Poder leer el valor de este estado
  //2- Poder modificar el estado

  int _contador = 0;
  int get contador => _contador;

  void incrementar() {
    _contador++;
    notifyListeners();
  }
}
