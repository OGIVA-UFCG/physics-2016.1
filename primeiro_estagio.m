clc % limpar variaveis

n = 4; % numero de cargas pontuais

% coordenadas das cargas pontuais
x = [0, 5, 5, 0];
y = [5, 5, 0, 0];
%fim

% valor das cargas
q = [10, -20, 20, -10];

% constante de Coulumb
ke = 8.9875517873681764e9;

% intervalo do campo eletrico
xi = linspace(-20,20,133);
yi = linspace(-20,20,133);
%fim

% preparação do grafico e das linhas de campo
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
% fim


% plotagem do grafico
figure
quiver(XI,YI,Ex./E,Ey./E);
hold on
plot(x, y, 'or')
axis([-20 20 -20 20])
grid on
% EOF