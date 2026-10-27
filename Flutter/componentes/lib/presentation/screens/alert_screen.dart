import 'package:componentes/theme/app_theme.dart';
import 'package:flutter/material.dart';

class AlertScreen extends StatelessWidget {
  const AlertScreen({super.key});

  void mostrarAlerta(BuildContext context){
    showAdaptiveDialog(
      context: context, 
      builder: AlertDialog(
        title: Text('Titulo de la alerta'),
      )
    );
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text('Alertas'), backgroundColor: Colors.redAccent),
      body: Center(
        child: ElevatedButton(
          style: ElevatedButton.styleFrom(
            backgroundColor: AppTheme.secondary,
            shape: StadiumBorder(),
          ),
          onPressed: () {
            mostrarAlerta();
          },
          child: Padding(
            padding: EdgeInsets.all(25),
            child: Text('Mostrar Alerta'),
          ),
        ),
      ),
    );
  }
}
