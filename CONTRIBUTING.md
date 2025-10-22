# Guía para contribuir

¡Gracias por tu interés en contribuir a este proyecto! Antes de empezar, por favor lee las siguientes pautas para asegurar una colaboración fluida y organizada.
El sistema está dividido en **dos repositorios principales**:
- 🧠 **Backend:** desarrollado con **Spring Boot (Java)**
- 🎨 **Frontend:** desarrollado con **React (Node.js + npm)**

## Cómo puedo contribuir


### 📋 Requisitos previos

Antes de contribuir, asegúrate de tener instalado:

- [Git](https://git-scm.com/)
- [Node.js](https://nodejs.org/) y [npm](https://www.npmjs.com/)
- Un editor de texto recomendado: [VS Code](https://code.visualstudio.com/)
- Un IDE recomendado: [IntelliJ IDEA](https://www.jetbrains.com/idea/)

---

### 🚀 Cómo empezar

1. **Haz un fork** del repositorio.
2. **Clona tu fork** en tu máquina local:
   ```bash
   git clone https://github.com/<tu-usuario>/<backend-repo>.git
   git clone https://github.com/<tu-usuario>/<frontend-repo>.git
3. **Agrega el remoto original (upstream)**:
   ```bash
   git remote add upstream 
   https://github.com/MaryenAguilar/Herramientas-De-Desarrollo.git

   git remote add upstream https://github.com/MaryenAguilar/HerramientasBackend.git
4. **Sincroniza tu fork** con el repositorio principal:
   ```bash
   git fetch upstream
   git checkout develop
   git merge upstream/develop
   git push origin develop
### 🌿 Convención de Nombres de Ramas

Usamos una convención estandarizada para mantener el control de versiones y facilitar la colaboración.  
Cada rama debe indicar su **propósito** seguido de una **descripción corta** en minúsculas y separada por guiones.

**Formato general:**
- `feat/` → nueva funcionalidad  
- `fix/` → corrección de errores  
- `refactor/` → mejora del código sin cambiar funcionalidad  
- `docs/` → documentación  

**Ejemplos:**
- Feature/CrearLogin
- Feature/CrearRegistro
- Feature/ImplementarReclamos
- Fix/ErrorLogin

### 🧾 Formato de Mensajes de Commit

Cada commit debe ser **claro, conciso y estructurado**.

**Formato:**
- Verbo + Funcionalidad + Issue asignado

**Ejemplo:**
- Implementar sistema de reclamos (Closes #3)

### 🔁 Procedimiento para Pull Requests (PR)

1. **Crea una rama** a partir de `main` o `develop`.  
   ```bash
   git checkout -b feat/nueva-funcionalidad
2. Realiza los cambios y haz commit:
3. Realiza tus commits siguiendo las convenciones anteriores.
4. Haz push a tu fork o rama remota.
5. Abre un Pull Request (PR) hacia el main.
6. En el PR:
   - Describe los cambios realizados.
   - Incluye capturas o ejemplos si aplica.
   - Menciona los Issues relacionados (Closes #...).
   - Espera la revisión de otro colaborador.
7. Una vez aprobado, será fusionado mediante para mantener un historial limpio.

### 🧩 Reglas de Colaboración
#### 🔒 Branch Rules

- main: solo se actualiza desde PRs revisados y aprobados.
- feature/*: para desarrollar nuevas funcionalidades.
- fix/*: para resolver errores puntuales.
- No hagas commits directos al main.

#### 🏷️ Tag Rules
Para mantener el repositorio organizado y facilitar la gestión de Issues y Pull Requests, seguimos estas reglas para el uso de etiquetas (tags):

- Usa etiquetas claras y descriptivas que reflejen el propósito del Issue o PR.
- Algunas etiquetas comunes incluyen:
  - `bug` para errores o fallos.
  - `enhancement` para mejoras o nuevas funcionalidades.
  - `documentation` para temas relacionados con la documentación.
  - `question` para dudas o consultas.
- Añade etiquetas relacionadas con el área afectada (backend, frontend, etc.) cuando sea posible.
- Evita el uso excesivo de etiquetas; elige las más relevantes.
- Los colaboradores con permisos pueden crear nuevas etiquetas si es necesario, pero siempre buscando coherencia con las existentes.


### 🧠 Gestión de Issues, Milestones y Tableros
#### 🐞 Issues

- Crea un Issue para reportar bugs, proponer mejoras o nuevas funciones.
- Usa etiquetas (labels) para clasificar: bug, enhancement, documentation, etc.
- Sé claro y proporciona pasos para reproducir errores o entender la propuesta.

#### 🎯 Milestones

- Los Milestones agrupan varios Issues bajo una meta común (ej. “Versión 1.0”).
- Cada Issue asignado a un Milestone contribuye a su progreso.
- Los Milestones ayudan a planificar lanzamientos o fases de desarrollo.

#### 📋 Tableros de Proyecto

- El Project Board visualiza el flujo de trabajo (por ejemplo, “To Do”, “In Progress”, “Done”).
- Cada Issue o PR debe ubicarse en la columna adecuada según su estado.
- El tablero se actualiza automáticamente con los cambios de Issues y PRs.

### Reportar errores (bugs)

1. Abre un [Issue](https://github.com/tu-usuario/tu-proyecto/issues).
2. Describe el error de forma clara:
   - Qué esperabas que pasara.
   - Qué pasó realmente.
   - Pasos para reproducirlo.
   - Incluye capturas de pantalla o logs si es posible.

### Proponer una mejora o nueva funcionalidad

1. Abre un [Issue](https://github.com/tu-usuario/tu-proyecto/issues) con la etiqueta `feature request`.
2. Explica claramente la idea y su beneficio para el proyecto.

### Enviar código (Pull Request)

1. Haz un fork del repositorio y crea una rama nueva:
   ```bash
   git checkout -b nombre-de-tu-rama
2. Realiza los cambios y haz commit:
   ```bash
   git add .
   git commit -m "feat: agrega nueva funcionalidad X"
2. Sube tu rama:
   ```bash
   git push origin feature/nueva-funcionalidad
## Gracias

Gracias por contribuir y ayudar a mejorar este proyecto. Cada contribución, por pequeña que sea, hace una gran diferencia.