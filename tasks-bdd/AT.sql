
Table Usuarios {
  id_usuario int [pk, increment]
  nome varchar(100)
  telefone varchar(20)
  email varchar(100)
  cpf varchar(11)
}


Table Autores {
  id_autor int [pk, increment]
  nome varchar(100)
  data_nascimento date
  nacionalidade varchar(50)
}

Table Livros {
  id_livro int [pk, increment]
  titulo varchar(200)
  isbn varchar(13)
  ano_publicacao year
  id_autor int [ref: > Autores.id_autor]
}


Table Categorias {
  id_categoria int [pk, increment]
  nome varchar(50)
}


Table Livros_Categorias {
  id_livro int [ref: > Livros.id_livro]
  id_categoria int [ref: > Categorias.id_categoria]
}


Table Emprestimos {
  id_emprestimo int [pk, increment]
  id_usuario int [ref: > Usuarios.id_usuario]
  id_livro int [ref: > Livros.id_livro]
  data_emprestimo date
  data_devolucao date
}
