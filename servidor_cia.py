import socket
import json

alumnos = [
    ("000001", "pass123", "Ariel Borbon", "6641234567"),
    ("000002", "clave456", "Alberto Jimenez", "6642345678"),
    ("000003", "abc789", "Freddy Castro", "6643456789"),
    ("000004", "123abc", "Jesus Luzanilla", "6644567890"),
    ("000005", "xyz321", " Yuri German", "6645678901")
]

HOST = "localhost"
PORT = 5050

with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
    s.bind((HOST, PORT))
    s.listen()
    print("Servidor CIA en espera de conexión...")

    while True:
        conn, addr = s.accept()
        with conn:
            print(f"Conectado con {addr}")
            data = conn.recv(1024).decode("utf-8")

            if not data:
                continue

            try:
                credentials = json.loads(data)
                id_recibido = credentials.get("id")
                contrasena_recibida = credentials.get("contrasena")

                # Buscar coincidencia
                for alumno in alumnos:
                    if alumno[0] == id_recibido and alumno[1] == contrasena_recibida:
                        resultado = {
                            "idAlumno": alumno[0],
                            "nombreCompleto": alumno[2],
                            "telefono": alumno[3]
                        }
                        break
                else:
                    resultado = None  

                response = json.dumps(resultado)
                conn.sendall(response.encode("utf-8"))

            except json.JSONDecodeError:
                conn.sendall(b'{}')
