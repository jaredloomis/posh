(defproject denistakeda/posh "0.5.9"
  :description "Luxuriously easy and powerful Reagent / Datascript front-end framework"
  :url "http://github.com/denistakeda/posh/"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.11.1" :scope "provided"]
                 [org.clojure/clojurescript "1.11.132" :scope "provided"]
                 #_[datascript "1.8.1"]
                 #_[com.datomic/datomic-free "0.9.5407"]
                 [org.clojure/core.match "1.0.0"]]
  :plugins [[lein-cljsbuild "1.1.3"]]
  :profiles {:dev {:plugins [[lein-githooks "0.1.0"]]
                   :githooks {:auto-install true
                              :pre-push ["lein kaocha"]}}
             ;; datascript 1.x moved a conn's listeners out of the conn's
             ;; metadata into its inner state atom; posh reads both (see
             ;; `conn-listeners` in src/posh/plugin_base.cljc), so the test
             ;; suites run against 1.x.
             :test {:dependencies [[datascript "1.8.1"]
                                   [reagent "2.0.1"]
                                   [org.clojure/clojure "1.11.1"]
                                   [org.clojure/clojurescript "1.11.132"]]}
             :kaocha {:dependencies [[lambdaisland/kaocha "0.0-554"]
                                     [datascript "1.8.1"]
                                     [reagent "2.0.1"]
                                     [org.clojure/clojure "1.11.1"]
                                     [org.clojure/clojurescript "1.11.132"]
                                     [org.clojure/test.check "1.1.1"]
                                     ]}}
  :cljsbuild {:builds [ {:id "posh"
                         :source-paths ["src/"]
                         :figwheel false
                         :compiler {:main "posh.core"
                                    :asset-path "js"
                                    :output-to "resources/public/js/main.js"
                                    :output-dir "resources/public/js"} } ]}
  :scm {:name "git"
        :url "https://github.com/denistakeda/posh"}
  :aliases {"kaocha" ["with-profile" "+kaocha" "run" "-m" "kaocha.runner"]})
