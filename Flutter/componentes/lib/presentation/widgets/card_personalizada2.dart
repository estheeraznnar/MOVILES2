import 'package:flutter/material.dart';

class CardTipo2 extends StatelessWidget {
  final String urlImagen;
  final String? texto;

  const new({super.key, required this.urlImagen, this.texto});

  @override
  Widget build(BuildContext context) {
    return Card(
      clipBehavior:
          Clip.antiAlias, //para que la imagen no se salga de la parcela
      shape: RoundedRectangleBorder(
        borderRadius: BorderRadiusGeometry.circular(25),
      ),
      child: Column(
        children: [
          FadeInImage(
            fit: BoxFit.cover,
            image: NetworkImage(
              'https://imanesdeviaje.com/wp-content/uploads/2013/12/Lagos-de-Plitvice_11.jpg',
            ),
            placeholder: AssetImage('assets/jar-loading.gif'),
            width: double.infinity,
            height: 230,
            fadeInDuration: Duration(milliseconds: 1200),
          ),
          Container(
            padding: EdgeInsets.only(right: 20, top: 10, bottom: 10),
            child: Text(
              'Un bonito paisaje',
              style: TextStyle(color: Colors.teal, fontSize: 15),
            ),
          ),
        ],
      ),
    );
  }
}
