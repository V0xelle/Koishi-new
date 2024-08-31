/*     */ package Koishi.relics;
/*     */ 
/*     */ import Koishi.KoishiMod;
/*     */ import Koishi.cards.AbstractIdCard;
/*     */ import Koishi.util.TextureLoader;
/*     */ import basemod.abstracts.CustomRelic;
/*     */ import com.badlogic.gdx.graphics.Texture;
/*     */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*     */ import com.megacrit.cardcrawl.cards.CardGroup;
/*     */ import com.megacrit.cardcrawl.core.Settings;
/*     */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*     */ import com.megacrit.cardcrawl.localization.LocalizedStrings;
/*     */ import com.megacrit.cardcrawl.relics.AbstractRelic;
/*     */ import com.megacrit.cardcrawl.unlock.UnlockTracker;
/*     */ import com.megacrit.cardcrawl.vfx.cardManip.ShowCardAndObtainEffect;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ImperfectMetamorphosis
/*     */   extends CustomRelic
/*     */ {
/*  26 */   public static final String ID = KoishiMod.makeID("ImperfectMetamorphosis");
/*     */   
/*  28 */   private static final Texture IMG = TextureLoader.getTexture(KoishiMod.makeRelicPath("ImperfectMetamorphosis.png"));
/*  29 */   private static final Texture OUTLINE = TextureLoader.getTexture(KoishiMod.makeRelicOutlinePath("ImperfectMetamorphosis.png"));
/*     */   
/*     */   private static final int TRANSFORM_NUM = 2;
/*     */   private boolean cardsSelected = true;
/*     */   
/*     */   public ImperfectMetamorphosis() {
/*  35 */     super(ID, IMG, OUTLINE, AbstractRelic.RelicTier.RARE, AbstractRelic.LandingSound.HEAVY);
/*     */   }
/*     */ 
/*     */   
/*     */   public void onEquip() {
/*  40 */     this.cardsSelected = false;
/*  41 */     CardGroup tmp = new CardGroup(CardGroup.CardGroupType.UNSPECIFIED);
/*  42 */     Iterator<AbstractCard> var2 = AbstractDungeon.player.masterDeck.group.iterator();
/*     */     
/*  44 */     while (var2.hasNext()) {
/*  45 */       AbstractCard card = var2.next();
/*  46 */       if (!card.cardID.equals("Necronomicurse") && !card.cardID.equals("AscendersBane")) {
/*  47 */         tmp.addToTop(card);
/*     */       }
/*     */     } 
/*     */     
/*  51 */     if (tmp.group.isEmpty()) {
/*  52 */       this.cardsSelected = true;
/*     */     }
/*  54 */     else if (tmp.group.size() <= 2) {
/*  55 */       giveCards(tmp.group);
/*  56 */     } else if (!AbstractDungeon.isScreenUp) {
/*  57 */       AbstractDungeon.gridSelectScreen.open(tmp, 2, "Choose 2 cards for " + this.name + LocalizedStrings.PERIOD, false, false, false, false);
/*     */     } else {
/*  59 */       AbstractDungeon.dynamicBanner.hide();
/*  60 */       AbstractDungeon.previousScreen = AbstractDungeon.screen;
/*  61 */       AbstractDungeon.gridSelectScreen.open(tmp, 2, "Choose 2 cards for " + this.name + LocalizedStrings.PERIOD, false, false, false, false);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void update() {
/*  69 */     super.update();
/*  70 */     if (!this.cardsSelected && AbstractDungeon.gridSelectScreen.selectedCards.size() == 2) {
/*  71 */       giveCards(AbstractDungeon.gridSelectScreen.selectedCards);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void giveCards(ArrayList<AbstractCard> group) {
/*  77 */     this.cardsSelected = true;
/*  78 */     float displayCount = 0.0F;
/*  79 */     Iterator<AbstractCard> i = group.iterator();
/*     */     
/*  81 */     while (i.hasNext()) {
/*  82 */       AbstractCard card = i.next();
/*  83 */       card.untip();
/*  84 */       card.unhover();
/*  85 */       AbstractDungeon.player.masterDeck.removeCard(card);
/*     */       
/*  87 */       AbstractCard transformedCard = AbstractIdCard.returnTrulyRandomIdCard().makeCopy();
/*  88 */       UnlockTracker.markCardAsSeen(transformedCard.cardID);
/*     */       
/*  90 */       if (AbstractDungeon.screen != AbstractDungeon.CurrentScreen.TRANSFORM) {
/*  91 */         AbstractDungeon.topLevelEffectsQueue.add(new ShowCardAndObtainEffect(transformedCard, Settings.WIDTH / 3.0F + displayCount, Settings.HEIGHT / 2.0F, false));
/*  92 */         displayCount += Settings.WIDTH / 6.0F;
/*     */       } 
/*     */     } 
/*     */     
/*  96 */     AbstractDungeon.gridSelectScreen.selectedCards.clear();
/*  97 */     (AbstractDungeon.getCurrRoom()).rewardPopOutTimer = 0.25F;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdatedDescription() {
/* 103 */     return this.DESCRIPTIONS[0] + '\002' + this.DESCRIPTIONS[1];
/*     */   }
/*     */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/relics/ImperfectMetamorphosis.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */