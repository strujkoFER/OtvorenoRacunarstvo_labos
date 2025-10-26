CREATE TABLE programming_languages (
    id SERIAL PRIMARY KEY,
    name TEXT NOT NULL,
    year_created INT,
    creator TEXT,
    popular_frameworks TEXT[],
    primary_uses TEXT[],
    description TEXT,
    website TEXT
);

CREATE TABLE typing_discipline (
	id SERIAL PRIMARY KEY,
    language_id INT REFERENCES programming_languages(id) ON DELETE CASCADE,
    type_checking TEXT NOT NULL,
    strength TEXT NOT NULL
);

CREATE TABLE programming_styles (
	id SERIAL PRIMARY KEY,
    language_id INT REFERENCES programming_languages(id) ON DELETE CASCADE,
    style TEXT
);

--Inserti

INSERT INTO programming_languages 
(name, year_created, creator, popular_frameworks, primary_uses, description, website) VALUES
('Python', 1991, 'Guido van Rossum',
 ARRAY['Django','Flask','FastAPI','PyTorch'],
 ARRAY['Web development','Data science','Automation','Machine learning','Scripting'],
 'Python is a high-level, interpreted language known for its readability and versatility. Its large ecosystem and community make it ideal for beginners and professionals alike.',
 'https://www.python.org/'),
('Java', 1995, 'James Gosling',
 ARRAY['Spring','Hibernate','Jakarta EE'],
 ARRAY['Enterprise applications','Android development','Backend systems'],
 'Java is a class-based, object-oriented language designed to be portable and secure. It runs on the JVM and is widely used in enterprise and mobile applications.',
 'https://www.oracle.com/java'),
('C', 1972, 'Dennis Ritchie',
 ARRAY['GTK'],
 ARRAY['Operating systems','Embedded systems','Compilers','System programming'],
 'C is a foundational programming language that influenced many modern languages. It provides low-level access to memory and hardware, making it ideal for performance-critical software.',
 'https://www.c-language.org'),
('C++', 1985, 'Bjarne Stroustrup',
 ARRAY['Qt','Boost'],
 ARRAY['Game development','High-performance applications','System software'],
 'C++ builds on C by adding object-oriented and generic programming features. It balances control over hardware with high-level abstractions, making it powerful but complex.',
 'https://isocpp.org/'),
('JavaScript', 1995, 'Brendan Eich',
 ARRAY['React','Angular','Node.js','Express'],
 ARRAY['Web development','Server-side scripting','Desktop and mobile apps'],
 'JavaScript is the language of the web, enabling interactive and dynamic web pages. It runs in browsers and on servers via Node.js, and supports both functional and OOP styles.',
 'https://www.oracle.com/developer/javascript'),
('Go', 2009, 'Robert Griesemer, Rob Pike, and Ken Thompson',
 ARRAY['Gin','Beego','Fiber'],
 ARRAY['Cloud services','Backend APIs','DevOps tools','Networking'],
 'Go (or Golang) is a statically typed, compiled language designed for simplicity, concurrency, and performance. It’s widely used for scalable backend systems and cloud infrastructure.',
 'https://go.dev/'),
('Rust', 2006, 'Graydon Hoare',
 ARRAY['Rocket','Actix'],
 ARRAY['Systems programming','WebAssembly','Performance-critical software'],
 'Rust is designed for safety and concurrency without garbage collection. It guarantees memory safety through its ownership model, making it popular for system-level and high-performance code.',
 'https://www.rust-lang.org/'),
('C#', 2000, 'Microsoft',
 ARRAY['.NET','ASP.NET Core'],
 ARRAY['Game development','Desktop and web applications','Cloud services'],
 'C# is a modern, multi-paradigm language developed by Microsoft. It emphasizes type safety, memory management through garbage collection, and productivity features like LINQ, async programming, and rich tooling in Visual Studio.',
 'https://dotnet.microsoft.com/en-us/languages/csharp'),
('PHP', 1995, 'Rasmus Lerdorf',
 ARRAY['Laravel','Symfony','CodeIgniter'],
 ARRAY['Web development','Server-side scripting'],
 'PHP is a server-side scripting language designed for web development. Despite mixed opinions, it powers a significant portion of the web, including WordPress.',
 'https://www.php.net/'),
('Kotlin', 2011, 'JetBrains',
 ARRAY['Ktor','Spring Boot (Kotlin)','Jetpack Compose'],
 ARRAY['Android development','Backend systems','Cross-platform development'],
 'Kotlin is a modern JVM language that emphasizes safety and conciseness. Officially supported by Google for Android development, it interoperates seamlessly with Java and improves developer productivity.',
 'https://kotlinlang.org/');


INSERT INTO programming_styles (language_id, style) VALUES
-- Python
(1, 'Object-oriented'), (1, 'Procedural'), (1, 'Functional'),
-- Java
(2, 'Object-oriented'), (2, 'Imperative'), (2, 'Concurrent'),
-- C
(3, 'Procedural'), (3, 'Structured'),
-- C++
(4, 'Object-oriented'), (4, 'Procedural'), (4, 'Generic'),
-- JavaScript
(5, 'Event-driven'), (5, 'Functional'), (5, 'Imperative'),
-- Go
(6, 'Concurrent'), (6, 'Imperative'), (6, 'Structured'),
-- Rust
(7, 'Functional'), (7, 'Imperative'), (7, 'Concurrent'),
-- C#
(8, 'Object-oriented'), (8, 'Functional'), (8, 'Event-driven'),
-- PHP
(9, 'Imperative'), (9, 'Object-oriented'), (9, 'Functional'),
-- Kotlin
(10, 'Object-oriented'), (10, 'Functional');


INSERT INTO typing_discipline (language_id, type_checking, strength) VALUES
(1, 'Dynamic', 'Strong'),   -- Python
(2, 'Static', 'Strong'),    -- Java
(3, 'Static', 'Weak'),      -- C
(4, 'Static', 'Strong'),    -- C++
(5, 'Dynamic', 'Weak'),     -- JavaScript
(6, 'Static', 'Strong'),    -- Go
(7, 'Static', 'Strong'),    -- Rust
(8, 'Static', 'Strong'),    -- C#
(9, 'Dynamic', 'Weak'),     -- PHP
(10, 'Static', 'Strong');   -- Kotlin
