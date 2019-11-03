## Network flow

- Bipartite matching
  * e.g. Assigning jobs to machines capable of running those jobs
  
Determining the size of largest matching in a bipartite graph G

### Maximum-Flow Problem

We define a flow network as a directed graph G where
- Each edge has an associated positive capacity c<sub>e</sub>
- The is a single *source* node *s* where has no incoming edge
- The is a single *sink* node *t* where has no outgoing edge

Then Maximum-Flow problem is to arrange the traffic within this graph to use 
efficient use of resources.

* **NB** The problem is analogous to the problem of dividing the nodes into two set A and B where
s &isin; A and t &isin; B such. In this case we define a cut ...

#### Residual Graph

Having graph G we define a graph G<sub>f</sub> with the same vertices. For each edge *e = (u, v)* of G, We define 
two types of edges on the residual graph:

* **Forward edge** For edges where *f(e) < c<sub>e</sub>* we define a *forward edge* on G<sub>f</sub> 
with capacity equal to *f(e) - c<sub>e</sub>*
* **Backward edge** For edges where *f(e) > 0* we can undo the capacity by defining a backward edge *e' = (v, u)* on  G<sub>f</sub>
with capacity equal to *f(e)*

#### Augment Path

For a simple path *s-t* we define *bottleneck (P, f)* equal to minimum residual capacity on edges of P
```
def augment(f, P) {
    let b = bottleneck(f, P)
    for each edge (e = (u, v)) in P {
        if e is forward edge:
            increase f(e) in G by b
        else:
            e = (v, u)
            decrease f(e) in G by b
    }
}
```

#### Ford-Fulkerson algorithm

```
def max_flow {
    initialize f(e) = 0 for all e in G
    Gf = resigual_graph(G)
    while there is a s_t path in Gf {
        P = s_t
        f' = augment(f, P)
        Update f = f'
        Update Gf to be Gf'
    }
}
```
