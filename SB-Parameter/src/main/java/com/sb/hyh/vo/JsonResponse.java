package com.sb.hyh.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JsonResponse {

    @JsonProperty(value = "_embedded")
    private Embedded embedded;

    public Embedded getEmbedded() {
        return embedded;
    }

    public void setEmbedded(Embedded embedded) {
        this.embedded = embedded;
    }

    public class Embedded {
        // private Clique[] cliques;
        //
        // public Clique[] getCliques() {
        // return cliques;
        // }
        //
        // public void setCliques(Clique[] cliques) {
        // this.cliques = cliques;
        // }
    }
}