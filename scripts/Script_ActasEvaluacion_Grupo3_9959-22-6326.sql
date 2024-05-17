CREATE TABLE IF NOT EXISTS actaevaluacion (
    codigo_carrera VARCHAR(5) NOT NULL,
    codigo_curso VARCHAR(5) NOT NULL,
    codigo_seccion VARCHAR(5) NOT NULL,
	codigo_maestro VARCHAR(5),
    PRIMARY KEY (codigo_carrera, codigo_curso, codigo_seccion, codigo_maestro),
    FOREIGN KEY (codigo_carrera) REFERENCES carreras(codigo_carrera),
    FOREIGN KEY (codigo_curso) REFERENCES cursos(codigo_curso),
    FOREIGN KEY (codigo_seccion) REFERENCES secciones(codigo_seccion),
    FOREIGN KEY (codigo_maestro) REFERENCES maestros(codigo_maestro)
) ENGINE = InnoDB DEFAULT CHARSET=latin1;