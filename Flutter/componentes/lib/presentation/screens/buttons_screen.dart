import 'package:componentes/theme/app_theme.dart';
import 'package:flutter/material.dart';

class ButtonsScreen extends StatelessWidget {
  const ButtonsScreen({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text('Botones - Buttons')),
      body: _Buttons(),
      floatingActionButton: FloatingActionButton(
        child: Icon(Icons.arrow_back_ios),
        onPressed: () {},
      ),
    );
  }
}

class _Buttons extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return SingleChildScrollView(
      child: SizedBox(
        width: double.infinity,
        child: Padding(
          padding: EdgeInsetsGeometry.symmetric(horizontal: 10, vertical: 20),
          child: Column(
            children: [
              //Elevated Button
              ElevatedButton(onPressed: () {}, child: Text('Elevated Button')),
              ElevatedButton(
                onPressed: () {},
                child: Text('Elevated Button Disabled'),
              ),
              ElevatedButton.icon(
                onPressed: () {},
                label: Text('Elevated Icon Button'),
                icon: Icon(Icons.terminal),
              ),

              //Filed Button
              FilledButton(onPressed: () {}, child: Text('Filled')),
              FilledButton.icon(
                onPressed: () {},
                label: Text('Filled Icon'),
                icon: Icon(Icons.dnd_forwardslash_outlined),
                iconAlignment: .end,
              ),

              //outlined button
              OutlinedButton(onPressed: () {}, child: Text('Outlined')),
              OutlinedButton.icon(
                onPressed: () {},
                label: Text('Outlined Icon'),
                icon: Icon(Icons.offline_bolt_outlined),
              ),

              //Text Button
              TextButton(onPressed: () {}, child: Text('Text Button')),
              TextButton.icon(
                onPressed: () {},
                label: Text('Text button'),
                icon: Icon(Icons.text_fields_rounded),
              ),

              //Icon Button
              IconButton(onPressed: () {}, icon: Icon(Icons.face_2)),
              IconButton(
                onPressed: () {},
                icon: Icon(
                  Icons.face_2,
                  size: 50,
                  color: Colors.deepPurpleAccent,
                ),
                style: ButtonStyle(
                  backgroundColor: WidgetStatePropertyAll(
                    Colors.lightBlueAccent,
                  ),
                ),
              ),

              //Nos creamos nosotros nuestro boton personal
              SizedBox(height: 10),
              _BotonPropio(),
              SizedBox(height: 10),
              _BotonPropio(),
              SizedBox(height: 10),
              _BotonPropio(),
              SizedBox(height: 10),
              _BotonPropio(),
              SizedBox(height: 10),
              _BotonPropio(),
              SizedBox(height: 10),
              _BotonPropio(),
            ],
          ),
        ),
      ),
    );
  }
}

class _BotonPropio extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return ClipRRect(
      borderRadius: .circular(20),
      child: Material(
        color: Colors.amberAccent,
        child: InkWell(
          onTap: () {},
          child: Padding(
            padding: const EdgeInsets.all(20.0),
            child: Text('Mi propio boton'),
          ),
        ),
      ),
    );
  }
}
