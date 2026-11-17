import 'package:componentes/presentation/widgets.dart';
import 'package:flutter/material.dart';

class FormularioScreen extends StatelessWidget {
  const FormularioScreen({super.key});

  @override
  Widget build(BuildContext context) {
    //Globalkey nos permite controlar y validar el formulario completo
    final GlobalKey<FormState> _formKey = GlobalKey<FormState>();

    final Map<String, String> formValues = {
      'first_name': '',
      'last_name': '',
      'tfno': '',
      'email': '',
      'password': '',
      'role': '',
    };

    return Scaffold(
      appBar: AppBar(title: Text('Formularios')),
      body: SingleChildScrollView(
        child: Padding(
          padding: EdgeInsetsGeometry.symmetric(horizontal: 20, vertical: 10),
          child: Form(
            key: _formKey,
            child: Column(
              children: [
                CustomInputField(
                  labelText: 'Nombre',
                  hintText: 'Nombre del usuario',
                  formValues: formValues,
                  formProperty: 'first_name',
                ),
                SizedBox(height: 20),
                CustomInputField(
                  labelText: 'Apellidos',
                  hintText: 'Apellidos del usuario',
                  formValues: formValues,
                  formProperty: 'last_name',
                ),
                SizedBox(height: 20),
                CustomInputField(
                  labelText: 'Telefono',
                  hintText: 'Teléfono del usuario',
                  keyboardType: .phone,
                  formValues: formValues,
                  formProperty: 'tfno',
                ),
                SizedBox(height: 20),
                CustomInputField(
                  labelText: 'Email',
                  hintText: 'Correo del usuario',
                  keyboardType: .emailAddress,
                  formValues: formValues,
                  formProperty: 'email',
                ),
                SizedBox(height: 20),
                CustomInputField(
                  labelText: 'Contraseña',
                  hintText: 'Password del usuario',
                  obscureText: true,
                  formValues: formValues,
                  formProperty: 'password',
                ),
                SizedBox(height: 20),

                DropdownButtonFormField(
                  initialValue: 'Admin',
                  items: [
                    DropdownMenuItem(
                      child: Text('Administrador'),
                      value: 'Admin',
                    ),
                    DropdownMenuItem(
                      child: Text('Superusuario'),
                      value: 'Superuser',
                    ),
                    DropdownMenuItem(
                      child: Text('Developer'),
                      value: 'Developer',
                    ),
                    DropdownMenuItem(child: Text('Jr. Developer'), value: 'Jr'),
                  ],
                  onChanged: (value) {
                    formValues['role'] = value ?? 'Developer';
                  },
                ),

                SizedBox(height: 20),
                ElevatedButton(
                  onPressed: () {
                    print(formValues);
                  },
                  child: Text('Guardar'),
                ),
              ],
            ),
          ),
        ),
      ),
    );
  }
}
