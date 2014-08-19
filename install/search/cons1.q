// Investigadores con cooperador con publicación

FORALL R,S,P,T <- 
	R["file:research-ontology-schema.xml#cooperatesWith"->>resource(S)]
	and
	S["file:research-ontology-schema.xml#publication"->>resource(P)]
	and
	P["http://purl.org/dc/rec-dces-19990702#title"->>T].