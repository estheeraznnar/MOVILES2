import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

class SnackBarScreen extends StatelessWidget {
   
  const SnackBarScreen({super.key});

  void mostrarSnackBarPersonalizado(BuildContext context){

    // Eliminamos el snackbar para evitar repeticiones absurdas
    ScaffoldMessenger.of(context).clearSnackBars();


    final snackbar = SnackBar(
      content: Text('Hola a DAM 2!!!'),
      action: SnackBarAction(label: 'Ok!', onPressed: () {},),
      duration: Duration(seconds: 2),
      backgroundColor: CupertinoColors.activeGreen,
    );

    // Mostramos el Snacbar que nos hemos creado
    ScaffoldMessenger.of(context).showSnackBar( snackbar );
  }
  
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text('Snackbar'),),
      
      floatingActionButton: FloatingActionButton.extended(
        icon: Icon(Icons.remove_red_eye_outlined),
        onPressed: () => mostrarSnackBarPersonalizado(context), 
        label: Text('Mostrar Snackbar')
      ),
    );
  }
}