clc % limpar console

V = [0, 12, 15];
A = 2.0*10^12;

E = (((9.11*10^-31) * (A)) / -1.60*10^-19);

xi = linspace(-5,9,45);
yi = linspace(-5,9,45);

[XI,YI] = meshgrid(xi,yi);
u = cos(x).*y;
v = cos(x).*y;

figure
quiver(XI,YI,u,v)