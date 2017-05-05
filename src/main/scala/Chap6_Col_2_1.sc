

// 6.2.7.1 Heroes of the Silver Screen

case class Film(
                 name: String,
                 yearOfRelease: Int,
                 imdbRating: Double)

case class Director(
                     firstName: String,
                     lastName: String,
                     yearOfBirth: Int,
                     films: Seq[Film])

val memento = new Film("Memento", 2000, 8.5)
val darkKnight = new Film("Dark Knight", 2008, 9.0)
val inception = new Film("Inception", 2010, 8.8)

val highPlainsDrifter = new Film("High Plains Drifter", 1973, 7.7)
val outlawJoseyWales = new Film("The Outlaw Josey Wales", 1976, 7.9)
val unforgiven = new Film("Unforgiven", 1992, 8.3)
val granTorino = new Film("Gran Torino", 2008, 8.2)
val invictus = new Film("Invictus", 2009, 7.4)

val predator = new Film("Predator", 1987, 7.9)
val dieHard = new Film("Die Hard", 1988, 8.3)
val huntForRedOctober = new Film("The Hunt for Red October", 1990, 7.6)
val thomasCrownAffair = new Film("The Thomas Crown Affair", 1999, 6.8)

val eastwood = new Director("Clint", "Eastwood", 1930,
  Seq(highPlainsDrifter, outlawJoseyWales, unforgiven, granTorino, invictus))
val mcTiernan = new Director("John", "McTiernan", 1951,
  Seq(predator, dieHard, huntForRedOctober, thomasCrownAffair))
val nolan = new Director("Christopher", "Nolan", 1970,
  Seq(memento, darkKnight, inception))
val someGuy = new Director("Just", "Some Guy", 1990,
  Seq())
val directors = Seq(eastwood, mcTiernan, nolan, someGuy)
// TODO: Write your code here!


//nolan's films
nolan.films.map(_.name)

//allFilms
directors.flatMap(_.films.map(_.name))

//earliestMcTiernanFilm
mcTiernan.films.sortWith((a,b) => a.yearOfRelease < b.yearOfRelease).take(1)
mcTiernan.films.sortWith((a,b) => a.yearOfRelease < b.yearOfRelease).headOption

mcTiernan.films.foldLeft(Int.MaxValue)((current,film)=>math.min(current, film.yearOfRelease))

//films sorted by descending IMDB rating
directors.flatMap(_.films).sortWith((a,b) => a.imdbRating > b.imdbRating)
   //different form the the former flatMap


//average score
val scores =directors.flatMap(_.films.map(_.imdbRating))
scores.sum / scores.length

//val films = directors.flatMap(director => director.films)
//films.foldLeft(0)((a, b) => a.imdbRating + b.imdbRating ) / films.length
  //doen't work


//listings
//directors.flatMap(_.films)
directors.foreach{ d =>
  d.films.foreach { f =>
    println(s"Tonight! ${f.name} by ${d.lastName} !" )
  }
}

//directors.flatMap(d => (d.lastName,d.films.map(_.name)))


//earliest film by ANY director
directors.flatMap(d => d.films)
  .sortWith((a,b) => a.yearOfRelease < b.yearOfRelease)
  .headOption

//earliest film BY director



