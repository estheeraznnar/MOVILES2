import 'package:flutter/material.dart';

class ContadorScreen extends StatefulWidget {


  const new({super.key});

  @override
  State<ContadorScreen> createState() => _ContadorScreenState();
}

class _ContadorScreenState extends State<ContadorScreen> {
  int contador = 0;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          title: Text('Contador App'),
          centerTitle: true,
        ),
        body: Center(
          child: Column(
            mainAxisAlignment: .center,
            children: [
              Text(/*contador.toString()*/'$contador', style: TextStyle(fontSize: 130, fontWeight: .w100)),
              Text('Clicks', style: TextStyle(fontSize: 30),),
            ],
          ),
        ),
        floatingActionButton: FloatingActionButton(
          child: Icon(Icons.add),
          onPressed: () {
            //contador ++;
            //print(contador);
            setState(() {
               contador ++;
            });
          },
        ),
        /*floatingActionButton: Column(
          children: [
            FloatingActionButton(onPressed: onPressed)
          ],
        ),*/
      );
  }
}