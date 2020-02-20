package projetSopra.onafaim.model;

import com.fasterxml.jackson.annotation.JsonView;

import projetSopra.onafaim.model.jsonView.JsonViews;

@JsonView(JsonViews.Common.class)
public enum Etat {
	V, W;
	
	
}
