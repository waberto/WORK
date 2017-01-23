% chapeau(?Nom_du_chapeau,?Couleur,?Prix_en_euros).
chapeau(bonnet, vert, 10).
chapeau(beret, jaune, 13).
chapeau(foulard, orange, 25).

% vetement(v(?Nom_du_vetement,?Saison),?Couleur,?Prix).
vetement(v(robe, hiver), vert, 32).
vetement(v(tailleur, ete), vert, 53).
vetement(v(salopette, X), bleu, 27).

% relation ensemble_uni(?NomC, ?NomV, ?Couleur).
ensemble_uni(C, V, X):-chapeau(C, X, _), vetement(v(V,_),X,_).

% ensemble_prix(?NomC,?NomV,?Prix)
ensemble_prix(C, V, P):-chapeau(C,_,P1),vetement(v(V,_),_,P2),P is P1+P2.

% vetement(v(V, hiver),_,_),ensemble_prix(C,V,P), P<46.

% plus foncée

ps(marron, rouge).
ps(rouge, orange).
ps(orange, jaune).

ps(noir, bleu).
ps(bleu, vert).
ps(vert, gris).

plus_soutenu(C1, C2):-ps(C1,C2).
plus_soutenu(C1,C2):-ps(C1,C3), plus_soutenu(C3,C2).
% plus_soutenu(X,Y).
% ps(X,Y), plus_soutenu(Y,Z).

coordonnee(C,V):-chapeau(C,C1,_), vetement(v(V,_),C2,_),plus_soutenu(C1,C2).

ecart_couleur(C1,C2,D):-ps(C1,C2), D is 1.
ecart_couleur(C1,C2,D):-ps(C2,C1), D is -1.
% ecart_couleur(X,Y,Z).



