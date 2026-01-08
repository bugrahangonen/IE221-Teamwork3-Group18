# IE221 Teamwork 3 - Group 18

## Project Description
This project presents simulation-based demonstrations of fundamental
probability limit theorems using Java. The objective is to verify theoretical
results through numerical experiments and visualizations.

The following topics are covered:
- Strong Law of Large Numbers (SLLN)
- Central Limit Theorem (CLT)
- Monte Carlo estimation of π

### Strong Law of Large Numbers (SLLN)

The SLLN simulation demonstrates the almost sure convergence of the sample mean
to the expected value μ = 0.5. Independent random variables are generated from
the Uniform[0,1] distribution, and the cumulative sample mean is computed as
the number of observations increases.

A single long simulation is performed, and the convergence behavior is
visualized using a line chart. The reference line represents the true mean,
allowing direct comparison with the simulated sample mean.

**Monte Carlo Pi Estimation**

This simulation demonstrates the application of the Law of Large Numbers using a geometric Monte Carlo method to estimate the value of Pi (π). Independent random coordinate pairs (x, y) are generated uniformly within a unit square, and the algorithm determines whether each point falls inside the inscribed unit circle defined by $x^2 + y^2 \leq 1$.

The cumulative estimate of Pi is computed iteratively based on the ratio of points falling inside the circle to the total number of generated points. As the sample size increases, this ratio is scaled by a factor of 4 to approximate the true value of Pi. The simulation highlights how stochastic processes can be used to solve deterministic mathematical problems.

Convergence behavior is visualized using a dynamic line chart produced with the JFreeChart library. The estimated value is plotted against the number of iterations, with a reference line representing the true mathematical constant (Math.PI). The graphical output illustrates that as the number of random samples grows, the estimated value stabilizes and converges toward the actual value of Pi.

  ### Central Limit Theorem (CLT) Simulation

This simulation demonstrates the Central Limit Theorem using uniformly distributed random variables.
For different sample sizes (n = 2, 5, 10, 30, 50), repeated samples are generated and standardized sums
are computed according to the CLT formulation.

Histograms are produced to visualize how the distribution of the standardized sums converges
to the normal distribution as the sample size increases. This behavior illustrates convergence
in distribution, which is the key concept behind the Central Limit Theorem.

The results confirm that even when the underlying distribution is uniform, the distribution of
the standardized sample means approaches a normal distribution for sufficiently large sample sizes.


All simulations produce graphical outputs to illustrate convergence behavior.

---

## Tools and Libraries Used

- **Programming Language:** Java  
- **Development Environment:** Eclipse IDE  
- **Visualization Library:** JFreeChart  

JFreeChart is used to generate plots and export them automatically in PNG format.

---

## Project Structure

IE221-Teamwork3-Group18
├─ src
│ └─ simulation
│ ├─ SLLNSimulation.java
│ ├─ MonteCarloPi.java
│ └─ CLTSimulation.java
├─ results
│ └─ figures
│ ├─ slln.png
│ ├─ pi.png
│ └─ clt.png
├─ README.md
└─ .gitignore

yaml
Kodu kopyala

---

## How to Run

1. Clone the repository to your local machine.
2. Open the project using **Eclipse IDE**.
3. Add **JFreeChart** library to the Java Build Path.
4. Run the `main` method of each simulation class:

- `SLLNSimulation.java`
- `MonteCarloPi.java`
- `CLTSimulation.java`

Each execution generates a corresponding figure under the
`results/figures` directory.

---

## Output Files

- **results/figures/slln.png**  
  Demonstrates convergence of the sample mean according to the Strong Law of
  Large Numbers.

- **results/figures/pi.png**  
  Shows Monte Carlo estimation of π as the number of random points increases.

- **results/figures/clt.png**  
  Histogram illustrating convergence to the normal distribution in accordance
  with the Central Limit Theorem.

---

## Team Members

Buğrahan Gönen 2311021032
Mustafa Sait Bayraktar 2311021072
Kerem Kaan Gökçe 2311021009
Ahmet Eren Görgülü 2311021004

