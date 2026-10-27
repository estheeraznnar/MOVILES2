import 'package:componentes/models/menu_option.dart';
import 'package:componentes/theme/app_theme.dart';
import 'package:flutter/material.dart';

class HomeScreen extends StatelessWidget {
  const HomeScreen({super.key});

  @override
  Widget build(BuildContext context) {
    final menuOptions = <MenuOption>[
      MenuOption(
        ruta: "listview1",
        icon: Icons.list_alt,
        nombre: "ListView Tipo 1",
      ),
      MenuOption(
        ruta: "listview2",
        icon: Icons.list,
        nombre: "ListView Tipo 2",
      ),
      MenuOption(
        ruta: "alert",
        icon: Icons.add_alert,
        nombre: "Alertas - Alert",
      ),
      MenuOption(
        ruta: "card",
        icon: Icons.credit_card,
        nombre: "Tarjetas - Card",
      ),
    ];

    return Scaffold(
      appBar: AppBar(title: Text('Componentes en Flutter')),
      body: ListView.separated(
        itemBuilder: (context, i) => ListTile(
          leading: Icon(menuOptions[i].icon, color: AppTheme.halloweeen),
          title: Text(menuOptions[i].nombre),
          onTap: () {
            /*final route = MaterialPageRoute(
              builder: (context) => ListView2Screen(),
            );
            Navigator.push(context, route);*/

            Navigator.pushNamed(context, menuOptions[i].ruta);
          },
          trailing: Icon(Icons.arrow_forward_ios, color: AppTheme.halloweeen),
        ),
        separatorBuilder: (_, __) => Divider(),
        itemCount: menuOptions.length,
      ),
    );
  }
}
