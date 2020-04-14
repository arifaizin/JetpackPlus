package com.arifaizin.core.util

import com.arifaizin.core.data.model.movie.MovieModel
import com.arifaizin.core.data.model.tvshow.TvShowModel

class FakeDataDummy {
    companion object {
        fun generateDummyMovies(): List<MovieModel> {

            val movie = ArrayList<MovieModel>()

            movie.add(
                MovieModel(
                    1,
                    "A Star Is Born",
                    "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally\\'s career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.\n",
                    "/wrFpXMNBRj2PBiN4Z5kix51XaIZ.jpg",
                    "/mnDvPokXpvsdPcWSjNRPhiiLOKu.jpg",
                    "October 3, 2018"
                )
            )
            movie.add(
                MovieModel(
                    2,
                    "Aquaman",
                    "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm\\'s half-human, half-Atlantean brother and true heir to the throne.\n",
                    "/5Kg76ldv7VxeX9YlcQXiowHgdX6.jpg",
                    "/9QusGjxcYvfPD1THg6oW3RLeNn7.jpg",
                    "December 7, 2018"
                )
            )
            movie.add(
                MovieModel(
                    3,
                    "Avengers: Infinity War",
                    "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.\n",
                    "/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg",
                    "/bOGkgRGdhrBYJSLpXaxhXVstddV.jpg",
                    "April 25, 2018"
                )
            )
            movie.add(
                MovieModel(
                    4,
                    "Bird Box",
                    "Five years after an ominous unseen presence drives most of society to suicide, a survivor and her two children make a desperate bid to reach safety.</item>\n",
                    "/rGfGfgL2pEPCfhIvqHXieXFn7gp.jpg",
                    "/z6m7s4w4Erxnr5k2jc1TZR1AMva.jpg",
                    "December 13, 2018"
                )
            )
            movie.add(
                MovieModel(
                    5,
                    "Bohemian Rhapsody",
                    "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock \\'n\\' roll band Queen in 1970. Hit songs become instant classics. When Mercury\\'s increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.\n",
                    "/lHu1wtNaczFPGFDTrjCSzeLPTKN.jpg",
                    "/xcaSYLBhmDzJ6P14bcKe0KTh3QV.jpg",
                    "October 24, 2018"
                )
            )
            movie.add(
                MovieModel(
                    6,
                    "Bumblebee",
                    "On the run in the year 1987, Bumblebee finds refuge in a junkyard in a small Californian beach town. Charlie, on the cusp of turning 18 and trying to find her place in the world, discovers Bumblebee, battle-scarred and broken. When Charlie revives him, she quickly learns this is no ordinary yellow VW bug.\n",
                    "/fw02ONlDhrYjTSZV8XO6hhU3ds3.jpg",
                    "/17nDJQsGVim6oows2TlN98UacbO.jpg",
                    "December 15, 2018"
                )
            )
            movie.add(
                MovieModel(
                    7,
                    "Creed II",
                    "Between personal obligations and training for his next big fight against an opponent with ties to his family\\'s past, Adonis Creed is up against the challenge of his life.\n",
                    "/v3QyboWRoA4O9RbcsqH8tJMe8EB.jpg",
                    "/hZqx2JcZVjHSY2lMEMDC0XlObiw.jpg",
                    "November 21, 2018"
                )
            )
            movie.add(
                MovieModel(
                    8,
                    "Once Upon a Deadpool",
                    "A kidnapped Fred Savage is forced to endure Deadpool\\'s PG-13 rendition of Deadpool 2 as a Princess Bride-esque story that\\'s full of magic, wonder and zero F\\'s.\n",
                    "/5Ka49BWWyKMXr93YMbH5wLN7aAM.jpg",
                    "/7RqpTZq0mPpTcEwZ6qqwRZAFoLe.jpg",
                    "December 11, 2018"
                )
            )
            movie.add(
                MovieModel(
                    9,
                    "How to Train Your Dragon: The Hidden World",
                    "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.\n",
                    "/xvx4Yhf0DVH8G4LzNISpMfFBDy2.jpg",
                    "/lFwykSz3Ykj1Q3JXJURnGUTNf1o.jpg",
                    "January 3, 2019"
                )
            )
            movie.add(
                MovieModel(
                    10,
                    "Dragon Ball Super: Broly",
                    "Earth is peaceful following the Tournament of Power. Realizing that the universes still hold many more strong people yet to see, Goku spends all his days training to reach even greater heights. Then one day, Goku and Vegeta are faced by a Saiyan called \\'Broly\\' who they\\'ve never seen before. The Saiyans were supposed to have been almost completely wiped out in the destruction of Planet Vegeta, so what\\'s this one doing on Earth? This encounter between the three Saiyans who have followed completely different destinies turns into a stupendous battle, with even Frieza (back from Hell) getting caught up in the mix.\n",
                    "/f03YksE4NggUjG75toz4H1YAGRf.jpg",
                    "/6OTRuxpwUUGbmCX3MKP25dOmo59.jpg",
                    "December 14, 2018"
                )
            )

            return movie
        }

        fun generateDummyTvShow(): List<TvShowModel> {

            val tvShow = ArrayList<TvShowModel>()

            tvShow.add(
                TvShowModel(
                    1,
                    "The Flash",
"After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \\\"meta-human\\\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                    "/fki3kBlwJzFp8QohL43g9ReV455.jpg",
                    "/jC1KqsFx8ZyqJyQa2Ohi7xgL7XC.jpg",
                    "October 10, 2012"
                )
            )
            tvShow.add(
                TvShowModel(
                    2,
                    "Doom Patrol",
                    "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.\n",
                    "/nVN7Dt0Xr78gnJepRsRLaLYklbY.jpg",
                    "/sAzw6I1G9JUxm86KokIDdQeWtaq.jpg",
                    "February 15, 2019"
                )
            )
            tvShow.add(
                TvShowModel(
                    3,
                    "Dragon Ball",
                    "Long ago in the mountains, a fighting master known as Gohan discovered a strange boy whom he named Goku. Gohan raised him and trained Goku in martial arts until he died. The young and very strong boy was on his own, but easily managed. Then one day, Goku met a teenage girl named Bulma, whose search for the dragon balls brought her to Goku\\'s home. Together, they set off to find all seven dragon balls in an adventure that would change Goku\\'s life forever. See how Goku met his life long friends Bulma, Yamcha, Krillin, Master Roshi and more. And see his adventures as a boy, all leading up to Dragonball Z and later Dragonball GT.\n",
                    "/3wx3EAMtqnbSLhGG8NrqXriCUIQ.jpg",
                    "/iflq7ZJfso6WC7gk9l1tD3unWK.jpg",
                    "February 26, 1986"
                )
            )
            tvShow.add(
                TvShowModel(
                    4,
                    "Fairy Tail",
                    "Lucy is a 17-year-old girl, who wants to be a full-fledged mage. One day when visiting Harujion Town, she meets Natsu, a young man who gets sick easily by any type of transportation. But Natsu isn\\'t just any ordinary kid, he\\'s a member of one of the world\\'s most infamous mage guilds: Fairy Tail.\n",
                    "/58GKcwFV3lpVOGzybeMrrNOjHpz.jpg",
                    "/m2lugAG39sO0yCcuxEAu4fY5u1o.jpg",
                    "October 12, 2009"
                )
            )
            tvShow.add(
                TvShowModel(
                    5,
                    "Family Guy",
                    "Sick, twisted, politically incorrect and Freakin\' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he\'s not very bright but has a passion for tvShows). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
                    "/gBGUL1UTUNmdRQT8gA1LUV4yg39.jpg",
                    "/3OFrs1ets87VmRvG78Zg5eJTZeq.jpg",
                    "October 24, 2018"
                )
            )
            tvShow.add(
                TvShowModel(
                    6,
                    "The Flash",
                    "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion — and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won\\'t be long before the world learns what Barry Allen has become…The Flash.\n",
                    "/fki3kBlwJzFp8QohL43g9ReV455.jpg",
                    "/jC1KqsFx8ZyqJyQa2Ohi7xgL7XC.jpg",
                    "December 15, 2018"
                )
            )
            tvShow.add(
                TvShowModel(
                    7,
                    "Gotham",
                    "Before there was Batman, there was GOTHAM. Everyone knows the name Commissioner Gordon. He is one of the crime world\\'s greatest foes, a man whose reputation is synonymous with law and order. But what is known of Gordon\\'s story and his rise from rookie detective to Police Commissioner? What did it take to navigate the multiple layers of corruption that secretly ruled Gotham City, the spawning ground of the world\\'s most iconic villains? And what circumstances created them – the larger-than-life personas who would become Catwoman, The Penguin, The Riddler, Two-Face and The Joker?\n",
                    "/4XddcRDtnNjYmLRMYpbrhFxsbuq.jpg",
                    "/mKBP1OCgCG0jw8DwVYlnYqVILtc.jpg",
                    "November 21, 2018"
                )
            )
            tvShow.add(
                TvShowModel(
                    8,
                    "Grey\'s Anatomy",
                    "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
                    "/eqgIOObafPJitt8JNh1LuO2fvqu.jpg",
                    "/hF9yq8MxaTNLJITo0lwgO7eUoTx.jpg",
                    "December 11, 2018"
                )
            )
            tvShow.add(
                TvShowModel(
                    9,
                    "Hanna",
                    "This thriller and coming-of-age drama follows the journey of an extraordinary young girl as she evades the relentless pursuit of an off-book CIA agent and tries to unearth the truth behind who she is. Based on the 2011 Joe Wright film.\n",
                    "/5nSSkcM3TgpllZ7yTyBOQEgAX36.jpg",
                    "/oUuyMvdBIZiJHEGtKYrIZO7hyd7.jpg",
                    "January 3, 2019"
                )
            )
            tvShow.add(
                TvShowModel(
                    10,
                    "Iron Fist",
                    "Danny Rand resurfaces 15 years after being presumed dead. Now, with the power of the Iron Fist, he seeks to reclaim his past and fulfill his destiny.\n",
                    "/nv4nLXbDhcISPP8C1mgaxKU50KO.jpg",
                    "/xHCfWGlxwbtMeeOnTvxUCZRGnkk.jpg",
                    "December 14, 2018"
                )
            )

            return tvShow
        }
    }
}