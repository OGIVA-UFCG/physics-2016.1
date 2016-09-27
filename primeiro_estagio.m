% limpar console
clc

% numero de cargas pontuais
n = 4;

% coordenadas das cargas pontuais %
x = [0, 5, 5, 0];
y = [5, 5, 0, 0];
% fim %

% valor das cargas %
q = [10, -20, 20, -10];

% constante de Coulumb %
ke = 8.9875517873681764e9;

% linhas campo eletrico %
xi = linspace(-5,9,45);
yi = linspace(-5,9,45);
% fim %

% cálculos, preparação do grafico e das linhas de campo %
[XI, YI] = meshgrid(xi,yi);
zi = complex(XI,YI);
z = complex(x,y);

[ZI, Z] = ndgrid(zi(:),z(:));

dZ = ZI-Z;

Zn = abs(dZ);

E = (dZ./Zn.^3)*(q(:)*ke);
E = reshape(E, size(XI));
En = abs(E);
Ex = real(E);
Ey = imag(E);
% fim %


% plotagem do grafico %
quiver(XI,YI,Ex./E,Ey./E);
hold on

plot(x, y, 'o')
hold off

title('Seção 22-3 / Questão 9')
xlabel('eixo x')
ylabel('eixo y')
legend('linhas de campo', 'cargas pontuais', 'Location', 'southeast')
text(0, 5, '\leftarrow q1')
text(5, 5, '\leftarrow q2')
text(5, 0, '\leftarrow q3')
text(0, 0, '\leftarrow q4')

C = char('\rightarrow', 'E = E_yj = (1.02x10^5 N/C) j');

% caixa de texto com os dados
annotation('textbox',...
    [0.0251581259150805 0.207055214723926 0.134431918008785 0.699386503067485],...
    'String',{'a = 5cm', '', 'q1 = +10,0nC','q2 = -20,0nC','q3 = +20,0nC', 'q4 = -10,0nC'...
    '','E_x = 0','E_y = 1.02x10^5 N/C', '', C },...
    'FitBoxToText','on');

axis equal
grid on
% EOF

% apenas desativando warning
warning('off')