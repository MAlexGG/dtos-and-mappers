# Diferencia de validaciones en el DTO, la Entidad y el Servicio:

## Objetivo
Un alumno puede registrarse en la web de la universidad, en donde podrá encontrar su perfil y materias a la que está apuntado.

Las reglas de la universidad es que el alumno no puede modificar a través de la web sus nombres, sus apellidos ni su número de identidad, porque la universidad quiere asegurarse de tener registrado una persona real.

1. En la entidad Student tenemos los siguientes atributos: id, name, lastname, phone, email, DNI/NIE.

2. Cuando el alumno entra en su perfil, puede ver todos sus datos excepto el id por lo que se necesitará un DTO Response para que no se envíe el id. 

3. Cuando queremos que devuelva la lista de estudiantes solo con su nombre y apellido, también podemos usar un DTO Response.

4. Cuando el alumno quiera modificar sus datos, tales como nombre, apellido y DNI/NIE en el servicio estará la lógica de negocio para restringir esos cambios, en el que mediante los setters solo puede modificar los campos de phone y email. Deberá también tener un DTO Request para proteger los datos que el cliente puede ingresar.

5. El DTO Request, que tiene los atributos de phone y email llevará validaciones para validar que el formato sea correcto, tales como:
    - @NotBlank
    - @NotNull -> para Integer (con int puede pasar)
    - @Email
    - @Pattern -> para que no se puedan pasar caracteres especiales tales como <> = ?

6. La entidad llevará validaciones de integración de la base de datos tales como:
    - @Column(nullable = false, unique = true) -> para validar que los campos de email, phone y DNI/NIE sean únicos y no puedan entrar valores nulos. 
    - @Column(nullable = false, length = 100) -> para validar que los campos de name y lastname tengan restricción de longitud.

7. Para el caso del administrador que pueda cambiar todos los datos del alumno se deberá crear otro DTO request que valide:
- @Size(min=9, max=9) -> para el DNI -> solo se usa en Strings, arrays, Collections y Map, valida la longitud del texto
- @Size(max=100) -> para que los campos de nombres y apellidos no sean mayores a 100 caracteres

8. Para no mapear en el servicio podemos usar mappers manuales, MapStruct, ModelMapper, Record:
    - Para mappers manuales, se debe hacer una clase mapeando cada método del response.
    - Para mappers MapStruct se ha de poner la dependencia MapStruct Core en el pom y dentro de annotation processor paths en pluggins, luego se crea una Interfaz: 
        <path>
            <groupId>org.mapstruct</groupId>
            <artifactId>mapstruct-processor</artifactId>
            <version>1.5.5.Final</version>
        </path>
    


