import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

class SnackbarScreen extends StatelessWidget {
  const SnackbarScreen({super.key});

  void mostrarSnackbarPersonalizado(BuildContext context) {
    //Eliminamos el snackbar para evitar repeticiones absurdas
    ScaffoldMessenger.of(context).clearSnackBars();

    final snackbar = SnackBar(
      content: Text('Hola Dam2'),
      action: SnackBarAction(label: 'oK!', onPressed: () {}),
      duration: Duration(seconds: 2),
      backgroundColor: CupertinoColors.link,
    );

    ScaffoldMessenger.of(context).showSnackBar(snackbar);
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text('Snackbar')),

      floatingActionButton: FloatingActionButton.extended(
        icon: Icon(Icons.remove_circle_outline_rounded),
        onPressed: () {
          mostrarSnackbarPersonalizado(context);
        },
        label: Text('Mostrar snackbar'),
      ),
    );
  }
}
