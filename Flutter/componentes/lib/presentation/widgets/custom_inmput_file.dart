import 'package:flutter/material.dart';

class CustomInputField extends StatelessWidget {
  final String? hintText;
  final String? labelText;
  final String? helperText;
  final IconData? icon;
  final IconData? suffixIcon;
  final bool obscureText;

  final TextInputType? keyboardType;

  final Map<String, String> formValues;
  final String formProperty;

  const new({
    super.key,
    this.hintText,
    this.labelText,
    this.helperText,
    this.icon,
    this.suffixIcon,
    this.obscureText = false,
    this.keyboardType,
    required this.formValues,
    required this.formProperty,
  });

  @override
  Widget build(BuildContext context) {
    return TextFormField(
      initialValue: '',
      textCapitalization: .words,
      keyboardType: keyboardType,
      obscureText: obscureText,
      onChanged: (value) => formValues[formProperty] = value,
      validator: (value) {
        if (value == null) return 'Este campo es requerido';
        return value.length < 3 ? 'Mínimo de 3 caracteres' : null;
      },
      autovalidateMode: .onUserInteraction,
      decoration: InputDecoration(
        hintText: hintText,
        labelText: labelText,
        helperText: helperText,
        //counterText: 'Contador'
        suffixIcon: suffixIcon == null ? null : Icon(suffixIcon),
        //prefixIcon: Icon( Icons.group_off_outlined),
        icon: icon == null ? null : Icon(icon),
        /*
        focusedBorder: OutlineInputBorder(
          borderSide: BorderSide(
            color: Colors.pinkAccent
          )
        ),
        border: OutlineInputBorder(
          borderRadius: .only( 
            bottomLeft: Radius.circular(10),
            topRight: Radius.circular(10)
          )
        )
        */
      ),
    );
  }
}

/*
            POR MI
import 'package:flutter/material.dart';

class CustomInmputFiled extends StatelessWidget {
  final String? hintText;
  final String? labelText;
  final String? helperText;
  final IconData? icon;
  final IconData? suffixIcon;

  const new({
    super.key,
    this.hintText,
    this.labelText,
    this.helperText,
    this.icon,
    this.suffixIcon,
  });

  @override
  Widget build(BuildContext context) {
    return TextFormField(
      autofocus: true, //cuando carguemos la pagina estar acomo señalado
      initialValue: 'Esther Aznar', //Salga este texto pot defecto
      textCapitalization: .words, //Para que se ponga la siguiente letra de despues de un espacio en mayuscula automaticamente
      onChanged: (value) {
        print(value); //Lo que escribas ira saliendo en la consola de depracion
      },
      validator: (value) {
        if (value == null) return 'Este campo es requerido';
        return value.length < 3 ? 'Minimo de 3 caracteres' : null;
      },
      autovalidateMode: .onUserInteraction,
      decoration: InputDecoration(
        hintText: 'Nombre del usuario',
        labelText: 'Nomre',
        helperText: 'solo letras',
        //counterText: 'Contador',
        suffixIcon: suffixIcon == null ? null : Icon(suffixIcon), //al final
        //prefixIcon: Icon(Icons.group_outlined), //al principio encima de la linea
        icon: icon == null
            ? null
            : Icon(icon), //al principio ocupando todo el espacio
        /*border: OutlineInputBorder(
          borderRadius: .only(
            bottomLeft: Radius.circular(10),
            topRight: Radius.circular(10),
          ),
        ),*/
      ),
    );
  }
}

*/
