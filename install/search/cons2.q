// Nombre de los investigadores

FORALL N <- EXISTS R 
	R:"file:research-ontology-schema.xml#Researcher"
	["file:research-ontology-schema.xml#name"->>literal(N)].