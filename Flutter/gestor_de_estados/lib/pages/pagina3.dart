import 'package:flutter/material.dart';
import 'package:gestor_de_estados/providers/contador_provider.dart';
import 'package:provider/provider.dart';

class Pagina3 extends StatelessWidget {
  const new({super.key});

  @override
  Widget build(BuildContext context) {
    return Container(
      color: Colors.pinkAccent,
      child: Column(
        children: [
          Center(
            child: Text(
              'El contador de Pagina 1 marca: ',
              style: TextStyle(fontSize: 25),
            ),
          ),
          Text(
            context.watch<ContadorProvider>().contador.toString(),
            style: TextStyle(fontSize: 120),
          ),
        ],
      ),
    );
  }
}
