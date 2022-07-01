# SCC0240_Projeto_BD
Projeto Final desenvolvido para a matéria SCC0240 - Base de Dados.

## Membros

Giovanni Shibaki Camargo – 11796444\
João Pedro Gavassa Favoretti – 11316055\
Lucas Keiti Anbo Mihara – 11796472\
Lucas Pilla Pimentel – 10633328\
Rodrigo Lopes Assaf – 11795530

## Descrição da aplicação
A aplicação idealizada pertencerá à realidade criada dentro do Mundo Pokémon, uma realidade fictícia. Em um escopo geral, ela visa ajudar a gerenciar algumas das experiências vividas por parte das pessoas dessa realidade, como: gerenciar suas batalhas, seus itens e seus pokémons. O usuário alvo da aplicação serão os Treinadores do Mundo Pokémon. O nome “Treinador” é a denominação para uma pessoa do Mundo Pokémon que possui o trabalho de interagir com os Pokémons (animais do mundo fictício) e treiná-los para torná-los mais fortes.
  
Dentre as funcionalidades que o usuário encontrará ao utilizar a aplicação estão: a possibilidade de criar novas batalhas ou entrar em batalhas existentes no sistema, consultar seu histórico de batalhas ou de outros treinadores, criar novos torneios, que consistem em uma série de batalhas chaveadas de forma que nas últimas batalhas só reste os melhores competidores, entrar em torneios já criados por outros treinadores, criar ou entrar em operações de trocas de itens ou pokémons com outro treinador, cadastrar os pokémons obtidos em sua mochila, que se refere à parte da interface que armazena os pokémons de cada treinador. Além disso, o sistema  deve registrar as ações durante uma batalha, tais como o uso de itens, troca de pokémon, movimento de ataque ou saída da batalha.
  
De forma mais detalhada, abaixo serão listados todos os conceitos utilizados para descrever a aplicação: O treinador é uma pessoa comum no Mundo Pokémon, mas que coleciona pokémons e pode treiná-los para batalhas e/ou torneios. Cada treinador possui um conjunto de pokémons que pertencem a ele e estes são chamados de pets. Além disso, um treinador pode possuir um conjunto de itens, chamado de pertences. Ele também pode possuir um histórico de suas batalhas e torneios que participou. Para participar de uma batalha, o treinador pode utilizar somente um subconjunto dos pets. Cada treinador pode ser distinguido dos demais pelo seu CPF. Além disso, cada treinador possui nome, gênero, data de nascimento e sua cidade natal. O treinador pode se especializar e se tornar um Mestre Pokémon, para isso o treinador deve possuir um ginásio e várias especialidades tais como gelo, raio, água, fogo, etc. Além disso, quando o treinador se torna um Mestre Pokémon, ele pode organizar torneios. O treinador também pode cadastrar um pokémon como descoberto caso encontre ele na natureza ou em uma batalha.
  
Os pokémons são criaturas que os treinadores capturam, colecionam, nomeiam e usam em batalhas. Cada pokémon possui um número único para ser diferenciado dos demais. Quando um treinador captura um pokémon selvagem, o pokémon se torna seu pet e é armazenado na mochila do treinador. Cada criatura pode possuir 1 ou 2 tipos (fogo, água, elétrico, etc). Cada pokémon tem um conjunto de ataques possíveis que podem ser utilizados e podem ter no máximo 4 ataques por vez. Além do número, cada pokémon tem um nome e sua descrição.
  
Um ataque é um movimento que o pokémon pode realizar durante a batalha para ferir o pokémon oponente, sendo que cada ataque sempre tem exatamente 1 tipo. Este ataque pode ser diferenciado dos demais pelo seu nome. Cada ataque contém uma descrição do ataque, além de sua potência, se ele é um ataque forte ou fraco, e a condição em que ele deixa ao adversário tal como paralizado, envenenado, queimado, e etc.

Os ataques específicos  que cada pokémon pode possuir é um subconjunto de todos os ataques existentes no Mundo Pokémon. Isso significa que dentre todos os ataques existentes no Mundo Pokémon, cada espécie de pokémon pode ter somente alguns. Além disso, dentro dos quatro ataques que cada pokémon possui atualmente, todos devem estar dentro do conjunto de ataques específicos para aquela espécie.

Existem 18 tipos no Mundo Pokémon, dentre eles podemos citar fire, water, grass, bug, fairy, dragon, etc. Cada um desses tipos podem ser fortes, fracos ou imunes em relação a outros tipos. O tipo é conhecido univocamente por um nome, e tem uma cor associada a ele para a interface. Cada tipo possui certa vantagem sobre as demais, ou seja, um ataque do tipo A possui certo multiplicador de impacto sobre pokémons dos demais tipos. O valor desse multiplicador possui valores entre 0, 0.5, 1 e 2, e é utilizado como um fator na hora de calcular o poder de cada ataque. Tanto os pokémons quanto os ataques têm tipos, sendo que cada ataque tem apenas um tipo e o pokémon pode ter um ou dois tipos. 

Um pet é um pokémon de certa espécie, mas que foi capturado por um treinador. Ao invés de possuir informações gerais da sua espécie, essa entidade possuí informações específicas da criatura que foi capturada, como um nome, a natureza dele (se ele é calmo, agressivo, inquieto, etc.), o sexo dele, seu peso, sua altura, e sua habilidade especial. Um exemplo de habilidade especial é a característica de não receber dano de ataques de certo tipo. Além disso, o pokémon pode ter cores especiais, diferentemente de outros na sua espécie, e assim será chamado de shiny. A quantidade limite de pets que um treinador possui não é definida, podendo ter até mais de um pokémon da mesma espécie. Cada pet é identificado pelo seu treinador, pelo seu nome e pela sua espécie.

Os Ataques do Pet representam os ataques que certo pet possui. Esses ataques podem ser no mínimo 1 e no máximo 4 por pokémon. Esses ataques sempre devem pertencer ao conjunto de ataques que a espécie do pokémon pode possuir. Por fim, esses são os ataques, ou movimentos, que o pet poderá utilizar durante uma batalha.

As batalhas são interações entre dois times, cada time é formado por um treinador com no máximo seis de seus pets. Cada batalha possui data/hora, o resultado final, e uma descrição da batalha em si, assim como sua categoria. A batalha pode ser identificada dentre as demais pelos treinadores que participaram da batalha e a data/hora de acontecimento. Uma batalha também é associada aos itens que podem ter sido utilizados nela. O conceito de batalha pode ser de dois diferentes tipos: Individual e Competitiva. A batalha é identificada como Competitiva quando pertence à um torneio, caso contrário é identificada como Individual. De modo específico, a batalha individual possui o local de acontecimento. Do mesmo modo, a batalha competitiva possui a informação da etapa que aconteceu durante o campeonato, como eliminatória, oitavas, quartas, semi e final, etc.

Os torneios envolvem diversas batalhas competitivas e são criadas por Mestres Pokémon. Dessa forma possuem múltiplos times. Com o chaveamento do torneio só restará um vencedor no final. Os torneios são identificados por seu local e data.

Os itens são todos os tipos de produtos que um treinador pode ter. Cada tipo de item fornece diferentes efeitos e podem ser utilizados para aumentar a vida dos pokémons, melhorar alguma habilidade do pokémon ou facilitar a captura do pokémon. Os itens são identificados unicamente pelo seu nome e possuem uma descrição do efeito que o item proporciona.

Os pertences são com bens de cada treinador. Cada pertence corresponde a um item em determinada quantidade. Cada pertence pode ser utilizado somente uma vez e possui registro de uso em batalha quando utilizado durante um combate.

## Implantação da base de dados e implementação do Sistema
Utilizamos o Intellij para oferecer uma interface gráfica e user friendly para realizar o protótipo operacional, usando linguagem Java em conjunto com o SGBD Relacional Oracle.

### Funcionalidade de Cadastro
Para a funcionalidade de cadastro, a query selecionada foi a de adição de um novo treinador no sistema, em que a interface verifica se os dados estão no formato certo, e há a verificação para não inserir dois treinadores com mesma chave (CPF), aceitando valores nulos para atributos não chave.

### Funcionalidade de Consulta
Para a funcionalidade de consulta, a query selecionada foi a de seleção de um pokémons no sistema, em que a interface aceita buscas por número, nome, e tipos do pokémon, verificando substrings no caso do nome. Pode se aplicar mais que um filtro por vez.
