# UN_RejectPlayer
Minecraft plugin that kick players from the sever when this died.

## Ejecución
Para que funcione el plugin en esta versión debes crear una carpeta y un archivo en el folder de plugins así:

```bash
plugins
│ 
├── UN_RejectPlayer
│   └── config.yml
└── UN_RejectPlayer-1.0.0.jar
```
El contenido del archivo `config.yml` es:
```yml
activate: true
```
Teniendo en cuenta lo anterior, para poder activar/desactivar el plugin debemos modificar el archivo en cuestión y ejecutar `reloadunrp`para recargar el plugin.

*Para administrar las muertes de un jugador se deben usar comandos de [CMI](https://www.zrips.net/cmi/commands/user-meta/)*
