package rww.ui.foaf

import japgolly.scalajs.react.ReactComponentB
import japgolly.scalajs.react.vdom.prefix_<^._
import rww.ontology.ContactLocation
import rww.ui.foaf.{FoafStyles => style}

import scalacss.ScalaCssReact._

/**
 * Created by hjs on 17/05/2015.
 */
object ContactLocationInfo {
  val ContactLocationInfo = ReactComponentB[WProps[(String,ContactLocation)]]("ContactLocationInfo")
    .initialState(None)
    .renderP(($,P)=> {
    val (homeTp,cl) = P.about
    <.li()(
      <.span(style.clearfix,style.span3)(
        <.div(style.titleCase)(homeTp) ,
        for (addr<-cl.address) yield <.span()(AddressInfo(P.copy(about=addr)))
      )
    )
  }).build

  def apply(p: WProps[(String,ContactLocation)]) = {
    ContactLocationInfo(p)
  }
}
