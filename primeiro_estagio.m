clc % limpar variaveis

n = 2; % numero de cargas

% coordenadas
x = [0, 1];
y = [0, 0];
%fim
display(x);

% cargas
q = [-5, 2];

% constante de Coulumb
ke = 8.9875517873681764e9;

% intervalo do campo eletrico
xi = linspace(-1,1,10);
yi = linspace(-1,1,10);
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
axis equal
grid on
% EOF