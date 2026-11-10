import 'package:flutter/material.dart';

class SliderScreen extends StatefulWidget {
  const SliderScreen({super.key});

  @override
  State<SliderScreen> createState() => _SliderScreenState();
}

class _SliderScreenState extends State<SliderScreen> {
  //me creo un double para coger el valor del slider
  double _valorSlider = 20;
  //me creo un buleano para activar el checkbox
  bool _sliderActivado = true;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text('Slider & Checks')),
      body: Column(
        children: [
          Slider.adaptive(
            min: 30,
            max: 400,
            value: _valorSlider,
            onChanged:
                _sliderActivado //si el checkbox esta activado se mueve el slider y sino nse queda estatico
                ? (value) {
                    setState(() {
                      _valorSlider = value;
                    });
                  }
                : null,
          ),

          /*Checkbox.adaptive(
            value: _sliderActivado,
            onChanged: (value) {
              _sliderActivado = value ?? true;
              setState(() {});
            },
          ),

          Switch.adaptive(
            value: _sliderActivado,
            onChanged: (value) {
              _sliderActivado = value ?? true;
              setState(() {});
            },
          ),*/
          /*CheckboxListTile.adaptive(
            title: Text('Habilitar Slider'),
            titleAlignment: .center,
            subtitle: Text('Esto es un subtitulo'),
            value: _sliderActivado,
            onChanged: (value) {
              _sliderActivado = value ?? true;
              setState(() {});
            },
          ),*/
          SwitchListTile.adaptive(
            title: Text('Habilitar Slider'),
            value: _sliderActivado,
            onChanged: (value) {
              _sliderActivado = value ?? true;
              setState(() {});
            },
          ),

          Expanded(
            child: SingleChildScrollView(
              child: Image(
                image: NetworkImage(
                  'https://cdn.pixabay.com/photo/2020/07/06/17/51/batman-5377804_1280.png',
                ),
                fit: BoxFit.contain,
                width: _valorSlider,
              ),
            ),
          ),
        ],
      ),
    );
  }
}
