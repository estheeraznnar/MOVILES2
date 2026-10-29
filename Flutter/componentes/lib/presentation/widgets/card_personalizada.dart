import 'package:flutter/material.dart';

class CardTipo1 extends StatelessWidget {
  const new({super.key});

  @override
  Widget build(BuildContext context) {
    return Card(
      child: Column(
        children: [
          ListTile(
            leading: Icon(Icons.photo_album_outlined),
            title: Text('Soy un titulo'),
            subtitle: Text(
              'Aliquip dolore sit officia aliqua exercitation velit nisi.',
            ),
          ),
          Padding(
            padding: const EdgeInsets.only(right: 5),
            child: Row(
              mainAxisAlignment: .end,
              children: [
                TextButton(onPressed: () {}, child: Text('Cancelar')),
                TextButton(onPressed: () {}, child: Text('Ok')),
              ],
            ),
          ),
        ],
      ),
    );
  }
}



